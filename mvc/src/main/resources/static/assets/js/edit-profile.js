document.addEventListener("DOMContentLoaded", function () {

    const passwordInput =
        document.querySelector('[name="password"]');

    const confirmPasswordInput =
        document.querySelector('[name="confirmPassword"]');

    const passwordMatchError =
        document.getElementById("password-match-error");

    const nextButton =
        document.getElementById("account-next-button");


    function passwordsMatch() {
        return passwordInput.value === confirmPasswordInput.value;
    }


    function showPasswordError() {
        passwordMatchError.style.display = "inline";
        confirmPasswordInput.classList.add("is-invalid");
    }


    function hidePasswordError() {
        passwordMatchError.style.display = "none";
        confirmPasswordInput.classList.remove("is-invalid");
    }

    function validatePasswordsWhileTyping() {

        // Both empty = valid.
        // This allows the user to leave the password unchanged.
        if (
            passwordInput.value === "" &&
            confirmPasswordInput.value === ""
        ) {
            hidePasswordError();
            return true;
        }

        // Don't show the message while the user has not
        // started typing the confirmation yet.
        if (confirmPasswordInput.value === "") {
            hidePasswordError();
            return false;
        }

        if (!passwordsMatch()) {
            showPasswordError();
            return false;
        }

        hidePasswordError();
        return true;
    }


    passwordInput.addEventListener(
        "input",
        validatePasswordsWhileTyping
    );

    confirmPasswordInput.addEventListener(
        "input",
        validatePasswordsWhileTyping
    );


    /*
     * Capture=true is intentional.
     *
     * Your wizard likely already has a listener attached to
     * ".next". This validation runs before that listener so
     * Step 2 cannot be opened when the passwords don't match.
     */
    nextButton.addEventListener(
        "click",
        function (event) {

            if (!passwordsMatch()) {

                event.preventDefault();
                event.stopImmediatePropagation();

                showPasswordError();

                confirmPasswordInput.focus();

                return false;
            }

            hidePasswordError();
        },
        true
    );
});