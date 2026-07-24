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
    otherPlacesLived: ""
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
  }
]);

print("*** Data Imported ***");