(function main(){
	
	var EPS = 1e-5;
	
	var param_a = document.getElementById('param_a');
	var param_b = document.getElementById('param_b');
	var param_c = document.getElementById('param_c');
	
	var button_run = document.getElementById('button_run');
	
	var printHasNoRoots = function printHasNoRoots() {
		var resultLine = "<p>There are not any real roots</p>";
		document.write(resultLine);
	};
	
	var printOneRoot = function printOneRoot(root) {
		var resultLine = "<p>There is a root x =" + root.toString() + "</p>";
		document.write(resultLine);
	};
	
	var printRoots = function printRoots(first, second) {
		var resultLine = "<p>There are some roots x<sub>1</sub> =" + first.toString() 
						+ " x<sub>2</sub> =" + second.toString() + "</p>";
		document.write(resultLine);
	};
	
	button_run.addEventListener('click', function calculate() {
		var a = + param_a.value;
		var b = + param_b.value;
		var c = + param_c.value;
		
		var d = b * b - 4.0 * a * c;
		
		if (d < -EPS) {
			printHasNoRoots();
			return;
		}
		
		if (Math.abs(d) < EPS) {
			var root = (-b) / (2.0 * a);
			printOneRoot(root);
			return;
		}
		
		var first = (-b - Math.sqrt(d)) / (2.0 * a);
		var second = (-b + Math.sqrt(d)) / (2.0 * a);
		
		printRoots(first, second);
	});
	
}).call(this);
