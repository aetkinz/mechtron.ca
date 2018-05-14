sync:
	browser-sync start --config bs-config.js
make:
	clj -m build
watch:
	clj -m watch
