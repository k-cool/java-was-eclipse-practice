/**
 * 검사 로직 정리하기. (lib)
 *	- 문제가 있으면 true, 없으면 fasle
 */

console.log("valid.js");

 
function isEmpty (input) { 
	return !input.value;
}

function lessThan (input, len) { 
	return input.value.length < len;
}

function greaterThan (input, len) { 
	return input.value.length > len;
}

function isNotNumber (input) { 
	return isNaN(input.value);
}

function isNotEqual (input1, input2) { 
	return input1.value !== input2.value;
}

function containKR(input){
	let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@._"
	
	for(let i=0; i< input.value.length; i++){
		if(ok.indexOf(input.value[i])===-1){			
			return true;
		}
	}
	
	return false;
}

// set를 넣으면 input 에 포함하지 않는지 여부
function notContains(input, set){
	for(let i=0; i< set.length; i++){
		if(input.value.indexOf(set[i])!==-1){
			return false;
		}
	}

	return true;	
}

// input, 확장자 넣으면 확장자가 맞는지 여부
// jpg, png, gif, jpeg, webp -> o
// np4-> x
function isNotType(input, type){
	type = "." + type;
	return input.value.include(type);
}



