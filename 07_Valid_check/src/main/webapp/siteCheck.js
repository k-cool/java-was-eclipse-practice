/**
 * 
 */

console.log("siteCheck.js");

const i1 = document.getElementById("i1");
const i2 = document.getElementById("i2");
const i3 = document.getElementById("i3");
const i4 = document.getElementById("i4");
const i5 = document.getElementById("i5");
const i6 = document.getElementById("i6");
const form = document.getElementById("form");


function call(){
	console.log("call");
	
	
	if(isEmpty(i1) || containKR(i1)){
		i1.focus();
		return alert("필수입력!");
	}
	
	if(lessThan(i2, 3) || greaterThan(i2, 10)){
		i2.focus();
		return alert("글자 수 오류!")
	}
	
	if(
		lessThan(i3, 5) 
		|| notContains(i3, "1234567890")
		|| notContains(i3, "QWERTYUIOPASDFGHJKLZXCVBNM")
	){
		i3.focus();
		return alert("비밀번호 양식 확인");
	}
	
	if(isNotEqual(i3, i4)){
		i4.focus()
		return alert("비밀번호 확인이 다릅니다.")
	}
	
	if(isEmpty(i5) || isNotNumber(i5)){
		i5.focus()
		return alert("숫자가 아닙니다.")
	}
	
	if(isNotType(i6,"jpg")){
		i6.value = "";
		return alert("숫자가 아닙니다.")
	}
	
	form.submit();
}