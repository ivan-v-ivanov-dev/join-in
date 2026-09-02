package com.joinin.post.mapper;

import com.joinin.post.model.PollOption;
import com.joinin.post.model.PostByIdEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HexFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class PostByIdMapper {

    private final ImageIdentityCalculator imageIdentityCalculator;

    public PostByIdEntity toEntity(
            String profileIdentity,
            String groupIdentity,
            String content,
            byte[] imageBytes,
            String youtubeUrl,
            String pollQuestion,
            List<String> pollOptions) {

        LocalDateTime postedAt = LocalDateTime.now();
        String validContent = content != null && !content.isBlank() ? content : null;
        byte[] validImageBytes = imageBytes != null && imageBytes.length > 0 ? imageBytes : null;
        String validYoutubeUrl = youtubeUrl != null && !youtubeUrl.isBlank() ? youtubeUrl : null;
        String validPollQuestion = pollQuestion != null && !pollQuestion.isBlank() ? pollQuestion : null;

        List<String> validPollOptions =
                pollOptions != null && !pollOptions.isEmpty()
                        ? pollOptions.stream().filter(option -> option != null && !option.isBlank()).toList() : null;

        if (validPollOptions != null && validPollOptions.isEmpty()) {
            validPollOptions = null;
        }

        boolean hasText = validContent != null;
        boolean hasImage = validImageBytes != null;
        boolean hasVideo = validYoutubeUrl != null;
        boolean isPoll = validPollQuestion != null && validPollOptions != null;

        return PostByIdEntity.builder()
                .postIdentity(generatePostIdentity(
                        profileIdentity,
                        validContent,
                        validImageBytes,
                        validYoutubeUrl,
                        validPollQuestion,
                        validPollOptions,
                        postedAt))
                .authorIdentity(profileIdentity)
                .groupIdentity(groupIdentity)

                .content(validContent)

                .hasText(hasText)
                .hasImage(hasImage)
                .hasVideo(hasVideo)
                .poll(isPoll)

                .imageIdentity(imageIdentityCalculator.generateImageIdentity(validImageBytes))

                .youtubeUrl(validYoutubeUrl)

                .pollQuestion(isPoll ? validPollQuestion : null)
                .pollOptions(isPoll ? mapPollOptions(validPollOptions) : null)

                .createdAt(postedAt)
                .build();
    }

    private List<PollOption> mapPollOptions(List<String> pollOptions) {

        return pollOptions.stream()
                .map(option -> PollOption.builder()
                        .optionIdentity(generatePollOptionIdentity(option, LocalDateTime.now()))
                        .optionText(option)
                        .voteCount(0)
                        .build())
                .toList();
    }

    private String generatePostIdentity(String profileIdentity, String content,
                                        byte[] imageBytes, String youtubeUrl, String pollQuestion,
                                        List<String> pollOptions, LocalDateTime postedAt) {

        try {
            StringBuilder valueToHash = new StringBuilder();

            valueToHash.append(profileIdentity);

            if (content != null && !content.isBlank()) {
                valueToHash.append("|content=").append(content);
            }

            if (imageBytes != null && imageBytes.length > 0) {
                valueToHash.append("|image=")
                        .append(HexFormat.of().formatHex(imageBytes));
            }

            if (youtubeUrl != null && !youtubeUrl.isBlank()) {
                valueToHash.append("|youtubeUrl=").append(youtubeUrl);
            }

            if (pollQuestion != null && !pollQuestion.isBlank()) {
                valueToHash.append("|pollQuestion=").append(pollQuestion);
            }

            if (pollOptions != null && !pollOptions.isEmpty()) {
                pollOptions.stream()
                        .filter(option -> option != null && !option.isBlank())
                        .forEach(option -> valueToHash.append("|pollOption=").append(option));
            }

            valueToHash.append("|postedAt=").append(postedAt);

            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(valueToHash.toString().getBytes(StandardCharsets.UTF_8));

            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Unable to generate post identity", e);
        }
    }

    private String generatePollOptionIdentity(String optionText, LocalDateTime createdAt) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.update(optionText.getBytes(StandardCharsets.UTF_8));
            digest.update(createdAt.toString().getBytes(StandardCharsets.UTF_8));

            return HexFormat.of().formatHex(digest.digest());

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Unable to generate poll option identity", e);
        }
    }
}
