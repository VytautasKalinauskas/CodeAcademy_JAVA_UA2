const fs = require('fs-extra');
const path = require('path');

const sourceDir = path.join(__dirname, '../src/app');
const destinationDir = path.join(__dirname, '../dist');

// Create the destination directory if it doesn't exist
fs.ensureDirSync(destinationDir);

// Copy files by extension recursively
function copyFiles(sourceDir, destinationDir, fileExtension) {
	const files = fs.readdirSync(sourceDir);

	files.forEach(file => {
		const sourcePath = path.join(sourceDir, file);
		const destinationPath = path.join(destinationDir, file);

		if (fs.statSync(sourcePath).isDirectory()) {
			fs.ensureDirSync(destinationPath);
			copyFiles(sourcePath, destinationPath, fileExtension);
		} else if (path.extname(file).toLowerCase() === fileExtension) {
			fs.copySync(sourcePath, destinationPath);
		}
	});
	console.log(`${fileExtension} files copied successfully!`);
}

copyFiles(sourceDir, destinationDir, '.html');
copyFiles(sourceDir, destinationDir, '.js');
