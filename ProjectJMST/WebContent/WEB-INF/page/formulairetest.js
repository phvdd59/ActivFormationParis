function checkLogin() {
    var login = document.getElementById('login').value,
        logintooltip = document.getElementById('logintooltip');
    if (login.match("[a-zA-Z0-9_-]{3,}$")) {
        logintooltip.style.display = 'none';
        return true;
    } else {
        logintooltip.style.display = 'inline-block';
        return false;
    }
}

function checkPassword() {
    var pass1 = document.getElementById('pass1').value,
        pass2 = document.getElementById('pass2').value,
        pass1tooltip = document.getElementById('pass1tooltip'),
        pass2tooltip = document.getElementById('pass2tooltip');
    if (pass1.length > 5) {
        pass1tooltip.style.display = 'none';
        if (pass1 === pass2) {
            pass2tooltip.style.display = 'none';
            return true;
        } else {
            pass2tooltip.style.display = 'inline-block';
            return false;
        }
    } else {
        pass1tooltip.style.display = 'inline-block';
        return false;
    }
}


function validateForm(event) {
    
    if (!(checkLogin() && checkPassword())) {
        event.preventDefault();
        document.getElementById('submitformtooltip').style.display = 'inline-block';
    }
}

document.getElementById('myForm').addEventListener('submit', validateForm, false);
