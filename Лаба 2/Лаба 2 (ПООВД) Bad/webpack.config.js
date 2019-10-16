let path = require("path");
const ExtractTextPlugin = require("extract-text-webpack-plugin");

const conf = {
  entry: "./src/index.ts",
  output: {
    path: path.resolve(__dirname, "./dist"),
    filename: "bundle.js",
    publicPath: "dist/"
  },
  resolve: {
    extensions: ["ts", "js"]
  },
  devServer: {
    overlay: true
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        loader: "babel-loader",
        exclude: /node_modules/
      },
      {
        test: /\.ts(x?)$/,
        exclude: /node_modules/,
        use: ["ts-loader"]
      },
      {
        test: /\.less$/,
        use: ExtractTextPlugin.extract({
          fallback: "style-loader",
          use: ["css-loader", "less-loader"]
        })
      }
    ]
  },
  plugins: [new ExtractTextPlugin("main.css")]
};

module.exports = (env, options) => {
  let production = options.mode === "production";
  conf.devtool = production ? false : "eval-sourcemap";
  return conf;
};
