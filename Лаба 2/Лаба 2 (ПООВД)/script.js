const fs = require("fs");

fs.readFile("0001_0001_00332_1_00329_01_30_1_01.mbv", function(err, logData) {
  // Если возникла ошибка, мы кидаем исключение
  // и программа заканчивается
  if (err) throw err;

  const buf = Buffer.from(logData);
  let obj = buf.values();
  for (let index = 0; index < obj.length; index++) {
    console.log(obj[index]);
  }
});
