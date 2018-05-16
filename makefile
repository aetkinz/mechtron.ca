build:
	clj -m build
sync:
	npx browser-sync start --config bs-config.js
watch:
	clj -m watch
