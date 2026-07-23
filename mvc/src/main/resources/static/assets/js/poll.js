let pollOptionCount = 2;

   function addPollOption() {
      pollOptionCount++;

      const container = document.getElementById("pollOptionsContainer");

      const input = document.createElement("input");
      input.type = "text";
      input.name = "options";
      input.className = "form-control mb-2";
      input.placeholder = "Option " + pollOptionCount;

      container.appendChild(input);
   }