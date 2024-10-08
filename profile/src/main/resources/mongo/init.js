use ("admin");
db.auth("rootuser", "rootpass");
console.log('*** Authentication with root user ***')

use ("storage");
db.createCollection("profiles");
console.log('*** Collection created ***')

db.profiles.insertMany([
  {
        identity: "1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032",
        firstName: "Petur",
        lastName: "Petrov",
        email: "petur@petur.com",
        aboutMe: "I am a teenager.",
        mobile: "+359 123 123 123",
        city: "Sofia",
        country: "Bulgaria",
        birthDate: "2008-05-17",
        gender: "Male",
        joined: "2020-07-06",
        status: "Single",
        website: "petur.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
  },
  {
        identity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
        firstName: "Georgi",
        lastName: "Tihomirov",
        email: "georgi@georgi.com",
        aboutMe: "I am a teenager.",
        mobile: "+359 123 123 123",
        city: "Sofia",
        country: "Bulgaria",
        birthDate: "2009-09-21",
        gender: "Male",
        joined: "2021-01-12",
        status: "Single",
        website: "petur.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
    },
    {
        identity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
        firstName: "Stoyan",
        lastName: "Dimitrov",
        email: "stoyan@stoyan.com",
        aboutMe: "I am a young person.",
        mobile: "+359 123 123 123",
        city: "Sofia",
        country: "Bulgaria",
        birthDate: "1988-03-01",
        gender: "Male",
        joined: "2018-12-15",
        status: "Married",
        website: "Stoyan.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
    },
    {
        identity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
        firstName: "Viktoriya",
        lastName: "Ivanova",
        email: "victoriya@victoriya.com",
        aboutMe: "I am a young person.",
        mobile: "+359 123 123 123",
        city: "Plovdiv",
        country: "Bulgaria",
        birthDate: "2001-03-11",
        gender: "Female",
        joined: "2019-06-08",
        status: "Single",
        website: "victoriya.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
    },
    {
        identity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
        firstName: "Mariya",
        lastName: "Stoyanova",
        email: "mariya@mariya.com",
        aboutMe: "I am a young person.",
        mobile: "+359 123 123 123",
        city: "Varna",
        country: "Bulgaria",
        birthDate: "2005-11-09",
        gender: "Female",
        joined: "2020-06-19",
        status: "Single",
        website: "mariya.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
    },
    {
        identity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
        firstName: "Konstantin",
        lastName: "Ventsislavov",
        email: "konstantin@konstantin.com",
        aboutMe: "I am a young person.",
        mobile: "+359 123 123 123",
        city: "Varna",
        country: "Bulgaria",
        birthDate: "1992-04-22",
        gender: "Male",
        joined: "2020-04-22",
        status: "Married",
        website: "konstantin.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
    },
    {
        identity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
        firstName: "Angel",
        lastName: "Ivanov",
        email: "angel@angel.com",
        aboutMe: "I am a young person.",
        mobile: "+359 123 123 123",
        city: "Sofiya",
        country: "Bulgaria",
        birthDate: "1995-05-27",
        gender: "Male",
        joined: "2020-04-22",
        status: "Married",
        website: "angel.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
     },
     {
        identity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
        firstName: "Iliya",
        lastName: "Terziev",
        email: "iliya@iliya.com",
        aboutMe: "I am a young person.",
        mobile: "+359 123 123 123",
        city: "Vratsa",
        country: "Bulgaria",
        birthDate: "1988-07-03",
        gender: "Male",
        joined: "2020-04-01",
        status: "Married",
        website: "iliya.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
      },
     {
        identity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
        firstName: "Tanya",
        lastName: "Venelinova",
        email: "tanya@tanya.com",
        aboutMe: "I am a young person.",
        mobile: "+359 123 123 123",
        city: "Gorna Oryahovitsa",
        country: "Bulgaria",
        birthDate: "2000-09-12",
        gender: "Female",
        joined: "2020-05-22",
        status: "Single",
        website: "tanya.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
      },
      {
        identity: "67c80c58573c12562067629782b72c455fbd8ab06bbf8dfbd4bc20331d1cbedf",
        firstName: "Silviya",
        lastName: "Teodorova",
        email: "silviya@silviya.com",
        aboutMe: "I am a young person.",
        mobile: "+359 123 123 123",
        city: "Vratsa",
        country: "Bulgaria",
        birthDate: "2001-02-15",
        gender: "Female",
        joined: "2020-05-22",
        status: "Single",
        website: "silviya.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
      },
      {
        identity: "41d52bee906b4347466558329fb7a6cbc24b5ab0a5f6c58e2e614decc764fab3",
        firstName: "Teodor",
        lastName: "Ivanov",
        email: "teodor@teodor.com",
        aboutMe: "I am a young person.",
        mobile: "+359 123 123 123",
        city: "Sofiya",
        country: "Bulgaria",
        birthDate: "1992-04-27",
        gender: "Male",
        joined: "2015-05-22",
        status: "Single",
        website: "teodor.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
      },
      {
        identity: "cda07e665379ec023b0577605bfd6f91770fe997d72b4e7d3b90e17c29a1ad9e",
        firstName: "Asen",
        lastName: "Asenov",
        email: "asen@asen.com",
        aboutMe: "I am a young person.",
        mobile: "+359 123 123 123",
        city: "Pleven",
        country: "Bulgaria",
        birthDate: "1995-05-07",
        gender: "Male",
        joined: "2016-05-22",
        status: "Single",
        website: "asen.com",
        hobbies: "I like to ride my bike to work, swim, and work out. I also like reading design magazines, going to museums, and watching good TV shows while it’s raining outside."
      }
]);
console.log('*** Data Imported ***')

