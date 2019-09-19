function componentToHex(c) {
  var hex = c.toString(16);
  return hex.length == 1 ? "0" + hex : hex;
}

function rgbToHex(r, g, b) {
  return "#" + componentToHex(r) + componentToHex(g) + componentToHex(b);
}

let divs = [];

for (let k = 0; k < 5; k++) {
  for (let i = 0; i <= 255; i++) {
    if (k === 0) {
      let div = document.createElement("div");
      div.style.backgroundColor = rgbToHex(0, 0, i);
      div.classList.add("innerdiv");
      divs.push(div);
      continue;
    } else if (k === 1) {
      let div = document.createElement("div");
      div.style.backgroundColor = rgbToHex(0, i, 255);
      div.classList.add("innerdiv");
      divs.push(div);
      continue;
    } else if (k === 2) {
      let div = document.createElement("div");
      div.style.backgroundColor = rgbToHex(0, 255, 255 - i);
      div.classList.add("innerdiv");
      divs.push(div);
      continue;
    } else if (k === 3) {
      let div = document.createElement("div");
      div.style.backgroundColor = rgbToHex(i, 255, 0);
      div.classList.add("innerdiv");
      divs.push(div);
      continue;
    } else if (k === 4) {
      let div = document.createElement("div");
      div.style.backgroundColor = rgbToHex(255, 255 - i, 0);
      div.classList.add("innerdiv");
      divs.push(div);
      continue;
    }
  }
}
for (let i = 0; i < divs.length; i++) {
  document.querySelector(".container").appendChild(divs[i]);
}

let field = document.createElement("div");
field.classList.add("field");
document.body.appendChild(field);
