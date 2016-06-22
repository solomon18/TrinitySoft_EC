/**
 * 
 */
function idUsable() {
	document.joinfrm.userId.value="${userId}";
	self.close();
}

function idCheck() {
	if (document.joinfrm.userId.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.joinfrm.userId.focus();
		return;
	}
	var url = "idcheck.jsp";
	window.open(url, "_blank_1", 
			    "toobar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}



