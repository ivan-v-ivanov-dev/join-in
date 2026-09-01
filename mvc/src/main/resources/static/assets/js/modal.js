document.addEventListener("DOMContentLoaded", function () {

    const postContent = document.getElementById("postContent");
    const imageInput = document.getElementById("imageInput");
    const youtubeInput = document.getElementById("youtubeInput");

    const pollQuestion = document.getElementById("pollQuestion");
    const pollOptionsContainer = document.getElementById("pollOptionsContainer");
    const addPollOptionButton = document.getElementById("addPollOption");


    function getPollOptionInputs() {
        return pollOptionsContainer.querySelectorAll(".poll-option-input");
    }

    function getRemoveButtons() {
        return pollOptionsContainer.querySelectorAll(".remove-poll-option");
    }

    function pollHasContent() {

        if (pollQuestion.value.trim() !== "") {
            return true;
        }

        return Array.from(getPollOptionInputs())
            .some(input => input.value.trim() !== "");
    }


    function enablePoll() {

        pollQuestion.disabled = false;
        addPollOptionButton.disabled = false;

        getPollOptionInputs().forEach(input => {
            input.disabled = false;
        });

        getRemoveButtons().forEach(button => {
            button.disabled = false;
        });
    }


    function disablePoll() {

        pollQuestion.disabled = true;
        addPollOptionButton.disabled = true;

        getPollOptionInputs().forEach(input => {
            input.disabled = true;
        });

        getRemoveButtons().forEach(button => {
            button.disabled = true;
        });
    }


    function updateState() {

        const hasText = postContent.value.trim() !== "";
        const hasImage = imageInput.files.length > 0;
        const hasVideo = youtubeInput.value.trim() !== "";
        const hasPoll = pollHasContent();


        // PHOTO MODE
        if (hasImage) {

            postContent.disabled = false;

            imageInput.disabled = false;
            youtubeInput.disabled = true;

            disablePoll();

            return;
        }


        // VIDEO MODE
        if (hasVideo) {

            postContent.disabled = false;

            imageInput.disabled = true;
            youtubeInput.disabled = false;

            disablePoll();

            return;
        }


        // NORMAL TEXT MODE
        if (hasText) {

            postContent.disabled = false;

            imageInput.disabled = false;
            youtubeInput.disabled = false;

            disablePoll();

            return;
        }


        // POLL MODE
        if (hasPoll) {

            postContent.disabled = true;

            imageInput.disabled = true;
            youtubeInput.disabled = true;

            enablePoll();

            return;
        }


        // EMPTY
        postContent.disabled = false;
        imageInput.disabled = false;
        youtubeInput.disabled = false;

        enablePoll();
    }


    // NORMAL TEXT
    postContent.addEventListener("input", function () {
        updateState();
    });


    // PHOTO
    imageInput.addEventListener("change", function () {

        if (imageInput.files.length > 0) {

            youtubeInput.value = "";

            pollQuestion.value = "";

            getPollOptionInputs().forEach(input => {
                input.value = "";
            });
        }

        updateState();
    });


    // YOUTUBE
    youtubeInput.addEventListener("input", function () {

        if (youtubeInput.value.trim() !== "") {

            imageInput.value = "";

            pollQuestion.value = "";

            getPollOptionInputs().forEach(input => {
                input.value = "";
            });
        }

        updateState();
    });


    // POLL QUESTION
    pollQuestion.addEventListener("input", function () {

        if (pollQuestion.value.trim() !== "") {

            postContent.value = "";
            imageInput.value = "";
            youtubeInput.value = "";
        }

        updateState();
    });


    // POLL OPTION TEXT
    pollOptionsContainer.addEventListener("input", function (event) {

        if (!event.target.classList.contains("poll-option-input")) {
            return;
        }

        if (event.target.value.trim() !== "") {

            postContent.value = "";
            imageInput.value = "";
            youtubeInput.value = "";
        }

        updateState();
    });


    // ADD POLL OPTION
    addPollOptionButton.addEventListener("click", function (event) {

        event.preventDefault();

        const optionNumber =
            getPollOptionInputs().length + 1;

        const row = document.createElement("div");

        row.className =
            "poll-option-row d-flex align-items-center gap-2 mb-2";

        row.innerHTML = `
            <input type="text"
                   name="pollOptions"
                   class="form-control poll-option-input"
                   placeholder="Option ${optionNumber}">

            <button type="button"
                    class="btn btn-outline-danger remove-poll-option">

                <span class="material-symbols-outlined">
                    close
                </span>

            </button>
        `;

        pollOptionsContainer.appendChild(row);
    });


    // DELETE POLL OPTION
    pollOptionsContainer.addEventListener("click", function (event) {

        const removeButton =
            event.target.closest(".remove-poll-option");

        if (!removeButton) {
            return;
        }

        event.preventDefault();

        const row =
            removeButton.closest(".poll-option-row");

        if (row) {
            row.remove();
        }

        updateState();
    });


    updateState();

});