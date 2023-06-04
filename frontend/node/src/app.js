const express = require("express")
const path = require("path")

const app = express()

app.use(express.static(path.join(__dirname, 'app')));

app.use("/css",	express.static(path.join(__dirname, "../node_modules/bootstrap/dist/css")))
app.use("/js",	express.static(path.join(__dirname, "../node_modules/bootstrap/dist/js")))
app.use("/js", express.static(path.join(__dirname, "../node_modules/jquery/dist")))
app.use("/js", express.static(path.join(__dirname, "./app")))
app.use("/style", express.static(path.join(__dirname, "../public/css")))
app.use("/assets", express.static(path.join(__dirname, "./assets")))

app.get('/', (req, res) => {
	res.sendIndex(path.join(__dirname, 'app'));
});

app.listen(5000, () => {
	console.log("Listening on port " + 5000)
})
