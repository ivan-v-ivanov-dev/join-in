use("admin");
db.auth("rootuser", "rootpass");
console.log("*** Authentication with root user ***");

use("storage");
db.createCollection("profiles");
console.log("*** Collection created ***");

db.profiles.insertMany([
  {
    identity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
    firstName: "Ivan",
    lastName: "Ivanov",
    aboutMe: "Software Engineer",
    mobile: "+359888111111",
    address: "1 Vasil Levski Blvd",
    birthDate: "1995-03-15",
    birthYear: "1995",
    birthplace: "Plovdiv",
    livesIn: "Plovdiv",
    gender: "Male",
    interestedIn: "Women",
    language: "Bulgarian, English",
    joined: "2026-07-17",
    status: "Single",
    phoneNumber: "+359888111111",
    website: "https://linkedin.com/in/ivan-v-ivanov-dev/",
    socialLink: "https://linkedin.com/in/ivan-v-ivanov-dev/",
    hobbies: "Programming, AI, Cloud Computing",
    work: "B2B contractor Ltd.",
    professionalSkills: "Java, Spring Boot, AWS, Kafka, MongoDB",
    college: "University of Veliko Tarnovo",
    currentCity: "Plovdiv",
    hometown: "Plovdiv",
    otherPlacesLived: "Vratsa"
  },
  {
    identity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
    firstName: "Petur",
    lastName: "Petrov",
    aboutMe: "Backend developer passionate about distributed systems.",
    mobile: "+359888222222",
    address: "25 Bulgaria Blvd",
    birthDate: "1993-08-11",
    birthYear: "1993",
    birthplace: "Sofia",
    livesIn: "Sofia",
    gender: "Male",
    interestedIn: "Women",
    language: "Bulgarian, English",
    joined: "2026-07-17",
    status: "Married",
    phoneNumber: "+359888222222",
    website: "",
    socialLink: "https://linkedin.com/in/peturpetrov",
    hobbies: "Cycling, Reading, Technology",
    work: "Tech Solutions Ltd.",
    professionalSkills: "Java, Spring, PostgreSQL, Docker",
    college: "Technical University of Sofia",
    currentCity: "Sofia",
    hometown: "Sofia",
    otherPlacesLived: "Varna"
  },
  {
    identity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
    firstName: "Georgi",
    lastName: "Georgiev",
    aboutMe: "Full-stack developer with a passion for modern web technologies.",
    mobile: "+359888333333",
    address: "18 Tsar Osvoboditel St",
    birthDate: "1997-01-22",
    birthYear: "1997",
    birthplace: "Varna",
    livesIn: "Varna",
    gender: "Male",
    interestedIn: "Women",
    language: "Bulgarian, English",
    joined: "2026-07-17",
    status: "Single",
    phoneNumber: "+359888333333",
    website: "",
    socialLink: "https://github.com/georgigeorgiev",
    hobbies: "Photography, Gaming, Hiking",
    work: "Digital Systems Ltd.",
    professionalSkills: "React, Java, Spring Boot, MongoDB",
    college: "University of Economics Varna",
    currentCity: "Varna",
    hometown: "Varna",
    otherPlacesLived: "Burgas"
  },
  {
    identity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
    firstName: "Stoyan",
    lastName: "Stoyanov"
  },
  {
    identity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
    firstName: "Victoriya",
    lastName: "Petrova"
  },
  {
    identity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
    firstName: "Mariya",
    lastName: "Georgieva"
  },
  {
    identity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
    firstName: "Konstantin",
    lastName: "Dimitrov"
  },
  {
    identity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
    firstName: "Angel",
    lastName: "Angelov"
  },
  {
    identity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
    firstName: "Iliya",
    lastName: "Iliev"
  },
  {
    identity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
    firstName: "Tanya",
    lastName: "Petrova"
  },

  // Mother
  {
    identity: "67c80c58573c12562067629782b72c455fbd8ab06bbf8dfbd4bc20331d1cbedf",
    firstName: "Silviya",
    lastName: "Ivanova"
  },

  // Father
  {
    identity: "41d52bee906b4347466558329fb7a6cbc24b5ab0a5f6c58e2e614decc764fab3",
    firstName: "Teodor",
    lastName: "Ivanov"
  },

  // Brother
  {
    identity: "cda07e665379ec023b0577605bfd6f91770fe997d72b4e7d3b90e17c29a1ad9e",
    firstName: "Asen",
    lastName: "Ivanov"
  },

  // Non-friends
  {
    identity: "8b94a3f1bdb9d79a74bb71d933c6d0dd6c4dd08f75b89d1cbfcdf462cb0b7fd2",
    firstName: "Martin",
    lastName: "Marinov"
  },
  {
    identity: "0e1f7c5f7b9e92df58bbd6d9a4c7a7d5be71bbdc40d5d3cbf7dd1b7c3fd8e4b5",
    firstName: "Daniel",
    lastName: "Dimitrov"
  },
  {
    identity: "3d9abcb92d1d574ef0d0d49b0cb62cb6d6fd6bb49d82f8a3a8e4a7a0d3aefb11",
    firstName: "Nikol",
    lastName: "Nikolova"
  },

  // Friendship requests
  {
    identity: "f1bc296565b36ec1932fd0b0889fb94f3fc14f56f1141f1327fd4f58cfa6a231",
    firstName: "Aleksandar",
    lastName: "Aleksandrov"
  },
  {
    identity: "991f49289c5745bbeba353af157a40c48edfed061ead6d417160d9b89a54baa6",
    firstName: "Desislava",
    lastName: "Dimitrova"
  },
  {
    identity: "aad12f3aa20775b329a00d0f0ccba97dafbc72fd925163e2e26f5ee91ec6b2cd",
    firstName: "Borislav",
    lastName: "Borisov"
  }
]);

print("*** Data Imported ***");