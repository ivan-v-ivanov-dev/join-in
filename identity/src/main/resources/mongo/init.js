use ("admin");
db.auth("rootuser", "rootpass");
console.log('*** Authentication with root user ***')

use ("storage");
db.createCollection("profiles");
console.log('*** Collection created ***')

db.profiles.insertMany([
    {
    identity: "429e71a7f1773bf2619c4c54ca4a7c67ab949efc7fffc1097a9629e8dff3528b",
    firstName: "Ivan",
    lastName: "Ivanov",
    email: "ivan@ivan.com",
    password: "$2b$12$LznTPqlU2E02QQoNGPZOwuNTRgZu.R2z/8rx8tM1lQHBR8k.p24vC"
  },
  {
    identity: "9b5d4f5c0a71d7fef2c7c9f5f8cb45f4c1d49d6c9d4c9b9e3d6f2b1c4f8e7a91",
    firstName: "Petur",
    lastName: "Petrov",
    email: "petur@petur.com",
    password: "$2b$10$AqvG3lP2bRkL7mH5TnJYHeNwX6Yg9LpQ2RmVsWtUxYz12345678901"
  },
  {
    identity: "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551",
    firstName: "Georgi",
    lastName: "Tihomirov",
    email: "georgi@georgi.com",
    password: "$2b$10$BfR9mLwQ8KsX2cHdUvNeApM3QzW4TjY6HgLpNrStUvWx987654321"
  },
  {
    identity: "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627",
    firstName: "Stoyan",
    lastName: "Dimitrov",
    email: "stoyan@stoyan.com",
    password: "$2b$10$CxLqN4sTvY8pHgKeQwRmJuPzA2BdEfGhIjKlMnOpQrSt987654321"
  },
  {
    identity: "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8",
    firstName: "Viktoriya",
    lastName: "Ivanova",
    email: "victoriya@victoriya.com",
    password: "$2b$10$DpR8yVnLkM5aBcDeFgHiJkLmNoPqRsTuVwXyZaBcDeFg123456789"
  },
  {
    identity: "8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f",
    firstName: "Mariya",
    lastName: "Stoyanova",
    email: "mariya@mariya.com",
    password: "$2b$10$EqP4zLhMnOpQrStUvWxYzAbCdEfGhIjKlMnOpQrStUv987654321"
  },
  {
    identity: "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85",
    firstName: "Konstantin",
    lastName: "Ventsislavov",
    email: "konstantin@konstantin.com",
    password: "$2b$10$FrH7xYzAbCdEfGhIjKlMnOpQrStUvWxYzAbCdEfGhIj123456789"
  },
  {
    identity: "519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71",
    firstName: "Angel",
    lastName: "Ivanov",
    email: "angel@angel.com",
    password: "$2b$10$GsJ8aBcDeFgHiJkLmNoPqRsTuVwXyZaBcDeFgHiJkLm987654321"
  },
  {
    identity: "a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6",
    firstName: "Iliya",
    lastName: "Terziev",
    email: "iliya@iliya.com",
    password: "$2b$10$HtK2LmNoPqRsTuVwXyZaBcDeFgHiJkLmNoPqRsTuVwX123456789"
  },
  {
    identity: "31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93",
    firstName: "Tanya",
    lastName: "Venelinova",
    email: "tanya@tanya.com",
    password: "$2b$10$IvL6PqRsTuVwXyZaBcDeFgHiJkLmNoPqRsTuVwXyZaB987654321"
  },
  {
    identity: "67c80c58573c12562067629782b72c455fbd8ab06bbf8dfbd4bc20331d1cbedf",
    firstName: "Silviya",
    lastName: "Teodorova",
    email: "silviya@silviya.com",
    password: "$2b$10$JwM5XyZaBcDeFgHiJkLmNoPqRsTuVwXyZaBcDeFgHi123456789"
  },
  {
    identity: "41d52bee906b4347466558329fb7a6cbc24b5ab0a5f6c58e2e614decc764fab3",
    firstName: "Teodor",
    lastName: "Ivanov",
    email: "teodor@teodor.com",
    password: "$2b$10$KxN3FgHiJkLmNoPqRsTuVwXyZaBcDeFgHiJkLmNoPqR987654321"
  },
  {
    identity: "cda07e665379ec023b0577605bfd6f91770fe997d72b4e7d3b90e17c29a1ad9e",
    firstName: "Asen",
    lastName: "Asenov",
    email: "asen@asen.com",
    password: "$2b$10$LyP7JkLmNoPqRsTuVwXyZaBcDeFgHiJkLmNoPqRsTuV123456789"
  },
  {
    identity: "8b94a3f1bdb9d79a74bb71d933c6d0dd6c4dd08f75b89d1cbfcdf462cb0b7fd2",
    firstName: "Martin",
    lastName: "Georgiev",
    email: "martin@martin.com",
    password: "$2b$10$MzQ4NoPqRsTuVwXyZaBcDeFgHiJkLmNoPqRsTuVwXyZ987654321"
  },
  {
    identity: "0e1f7c5f7b9e92df58bbd6d9a4c7a7d5be71bbdc40d5d3cbf7dd1b7c3fd8e4b5",
    firstName: "Daniel",
    lastName: "Kolev",
    email: "daniel@daniel.com",
    password: "$2b$10$NaR8RsTuVwXyZaBcDeFgHiJkLmNoPqRsTuVwXyZaBcD123456789"
  },
  {
    identity: "3d9abcb92d1d574ef0d0d49b0cb62cb6d6fd6bb49d82f8a3a8e4a7a0d3aefb11",
    firstName: "Nikol",
    lastName: "Dimitrova",
    email: "nikol@nikol.com",
    password: "$2b$10$ObS2TuVwXyZaBcDeFgHiJkLmNoPqRsTuVwXyZaBcDeF987654321"
  }
]);

print("*** Data Imported ***");

