/**
 * Form validator
 * @author Matheus Oliveira
 */

function validator() {
	let name = frmContact.name.value
	let phone = frmContact.phone.value

	if (name === "") {
		alert("Preencha o campo nome")
		frmContact.nome.focus()
		return false
	}
	if (phone === "") {
		alert("Preencha o campo phone")
		frmContact.phone.focus()
		return false
	}
	else{
		document.forms["frmContact"].submit()
	}
}