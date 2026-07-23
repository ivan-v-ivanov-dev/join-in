 const imageInput = document.getElementById("imageInput");
      const youtubeInput = document.getElementById("youtubeInput");

      imageInput.addEventListener("change", function () {
         if (imageInput.files.length > 0) {
            youtubeInput.value = "";
            youtubeInput.disabled = true;
         } else {
            youtubeInput.disabled = false;
         }
      });

      youtubeInput.addEventListener("input", function () {
         if (youtubeInput.value.trim() !== "") {
            imageInput.value = "";
            imageInput.disabled = true;
         } else {
            imageInput.disabled = false;
         }
      });