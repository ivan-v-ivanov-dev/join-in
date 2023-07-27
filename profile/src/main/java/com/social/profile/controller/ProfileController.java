package com.social.profile.controller;

import com.social.profile.model.dto.RegisterDto;
import com.social.profile.service.contracts.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ProfileController {

    private final LoginService loginService;
    private final RegisterService registerService;
    private final ProfileService profileService;
    private final PostService postService;
    private final CommentService commentService;
    private final ImageService imageService;
    private final RelationshipService relationshipService;
    private final ReactionService reactionService;

    public ProfileController(LoginService loginService,
                             RegisterService registerService,
                             ProfileService profileService,
                             PostService postService,
                             CommentService commentService,
                             ImageService imageService,
                             RelationshipService relationshipService,
                             ReactionService reactionService) {
        this.loginService = loginService;
        this.registerService = registerService;
        this.profileService = profileService;
        this.postService = postService;
        this.commentService = commentService;
        this.imageService = imageService;
        this.relationshipService = relationshipService;
        this.reactionService = reactionService;
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String authenticate(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model) {
        try {
            String profileIndentity = loginService.login(email, password);
            return "redirect:/profile?identity=" + profileIndentity;
        } catch (IllegalArgumentException illegalArgumentException) {
            model.addAttribute("error", illegalArgumentException.getMessage());
            return "error";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("registerDto") RegisterDto registerDto,
                               BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "register";
        }

        registerService.register(registerDto);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(@RequestParam("identity") String identity, Model model) {
        model.addAttribute("profile", profileService.findByIdentity(identity));
        model.addAttribute("profileImage", imageService.findProfileImage(identity));
        model.addAttribute("backgroundImage", imageService.findProfileBackgroundImage(identity));
        model.addAttribute("albumImages", imageService.findProfileAlbumImage(identity));
        model.addAttribute("posts", postService.findUserPosts(identity));
        model.addAttribute("postsCount", postService.findUserPostsCount(identity));
        model.addAttribute("friends", relationshipService.findFriends(identity));
        model.addAttribute("friendsCount", relationshipService.findFriendsCount(identity));
        return "profile";
    }

    @PostMapping("/post")
    public String post(@RequestParam("userIdentity") String userIdentity,
                       @RequestParam("content") String content) {
        postService.post(userIdentity, content);
        // TODO: Redirect to FEED when implemented
        return "redirect:/profile?identity=" + userIdentity;
    }

    @PostMapping("/post/view")
    public String editPostView(@RequestParam("postIdentity") String postIdentity,
                               @RequestParam("authorIdentity") String authorIdentity,
                               Model model) {
        model.addAttribute("post", postService.findByIdentity(postIdentity, authorIdentity));
        return "edit-post";
    }

    @PostMapping("/post/edit")
    public String editPost(@RequestParam("userIdentity") String userIdentity,
                           @RequestParam("postIdentity") String postIdentity,
                           @RequestParam("newContent") String newContent) {
        postService.edit(postIdentity, userIdentity, newContent);
        return "redirect:/profile?identity=" + userIdentity;
    }

    @PostMapping("/post/delete")
    public String deletePost(@RequestParam("userIdentity") String userIdentity,
                             @RequestParam("postIdentity") String postIdentity) {
        postService.delete(postIdentity, userIdentity);
        return "redirect:/profile?identity=" + userIdentity;
    }

    @PostMapping("/comment")
    public String comment(@RequestParam("commentAuthorIdentity") String commentAuthorIdentity,
                          @RequestParam("postIdentity") String postIdentity,
                          @RequestParam("postAuthorIdentity") String postAuthorIdentity,
                          @RequestParam("comment") String comment) {
        commentService.comment(commentAuthorIdentity, postIdentity, postAuthorIdentity, comment);
        return "redirect:/profile?identity=" + commentAuthorIdentity;
    }

    @PostMapping("/post/like")
    public String likeAPost(@RequestParam("reactingUserIdentity") String reactingUserIdentity,
                            @RequestParam("postIdentity") String postIdentity,
                            @RequestParam("postAuthorIdentity") String postAuthorIdentity) {
        reactionService.likePost(reactingUserIdentity, postIdentity, postAuthorIdentity);
        return "redirect:/profile?identity=" + reactingUserIdentity;
    }

    @PostMapping("/post/dislike")
    public String dislikeAPost(@RequestParam("reactingUserIdentity") String reactingUserIdentity,
                               @RequestParam("postIdentity") String postIdentity,
                               @RequestParam("postAuthorIdentity") String postAuthorIdentity) {
        reactionService.dislikePost(reactingUserIdentity, postIdentity, postAuthorIdentity);
        return "redirect:/profile?identity=" + reactingUserIdentity;
    }

    @PostMapping("/post/star")
    public String starAPost(@RequestParam("reactingUserIdentity") String reactingUserIdentity,
                            @RequestParam("postIdentity") String postIdentity,
                            @RequestParam("postAuthorIdentity") String postAuthorIdentity) {
        reactionService.starPost(reactingUserIdentity, postIdentity, postAuthorIdentity);
        return "redirect:/profile?identity=" + reactingUserIdentity;
    }

    @GetMapping("/signout")
    public String signOut() {
        return "redirect:/";
    }

    @GetMapping("/health")
    public String health() {
        return "Profile service is HEALTHY.";
    }
}
