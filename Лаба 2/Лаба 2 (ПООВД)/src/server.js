// const http = require("http");
// const fs = require("fs");

// http
//   .createServer(function(request, response) {
//     console.log(request.url);
//     switch (request.url) {
//       //Start of html-files queries
//       case "/":
//         response.writeHead(200, {
//           "Content-Type": "text/html"
//         });
//         response.end(fs.readFileSync("index.html", "utf8"));
//         break;
//       //End of html-files queries
//       //Start of css-files queries
//       case "/style.css":
//         response.writeHead(200, {
//           "Content-Type": "text/css"
//         });
//         response.end(fs.readFileSync("style.css", "utf8"));
//         break;
//       //End of css-files queries
//       //Start of JavaScript-files queries
//       case "/script.js":
//         response.writeHead(200, {
//           "Content-Type": "text/javascript"
//         });
//         response.end(fs.readFileSync("script.js", "utf8"));
//         break;
//       //End of JavaScript-files queries
//       //Start of image-files queries
//       //End of image-files queries
//       default:
//         response.writeHead(404, {
//           "Content-Type": "text/plain"
//         });
//         response.end("404, Not found");
//         break;
//     }
//   })
//   .listen(process.env.PORT || 3000, () => console.log("Server started"));
