"use strict";

(function() {

    var calculate = function calculate(values) {
        var res = 0;

        for (var i = 0; i < values.length; i++) {
            res += values[i];
        }

        return res;
    };

    var btnCalculate = document.getElementById('btn_calculate');

    btnCalculate.addEventListener('click', function() {
        var inputList = document.getElementById('input_list');
        var listValues = inputList.childNodes;
        var values = [];

        for (var i = 0; i < listValues.length; i++) {
            if (listValues[i].value != undefined) {
                var children = listValues[i].childNodes;

                for (var j = 0; j < children.length; j++) {
                    if (children[j].value != undefined) {
                        values[values.length] = + children[j].value;
                    }
                }
            }
        }

        var res = calculate(values);
        var spanResult = document.getElementById('result');
        spanResult.innerHTML = '<p>' + res + '</p>';
    });

    var btnPlus = document.getElementById('btn_plus'),
        btnMinus = document.getElementById('btn_minus');

    btnPlus.addEventListener('click', function() {
        var inputList = document.getElementById('input_list');
        var newInput = document.createElement('li');
        newInput.innerHTML = '<input type="text"><br>';
        inputList.appendChild(newInput);
    });

    btnMinus.addEventListener('click', function() {
        var inputList = document.getElementById('input_list');
        inputList.removeChild(inputList.lastChild);
    });

}).call(this);
