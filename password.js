function checkPassword(password){
    let minLength = 8;
    let minNumber = 1;
    let minLetter = 1;
    let minSpecial = 1;

    let errorLength = "Le mot de passe doit contenir au minimum " + minLength +" caratères.";
    let errorCheck = "Le mot de passe doit contenir au moins " + minNumber + " chiffre, " + minLetter + " lettre et " + minSpecial + " caractère spécial.";
    let validPassword = "Mot de passe valide.";


    let checkNumber = new RegExp(`(.*\\d.*){${minNumber},}`).test(password);
    let checkLetter = new RegExp(`(.*[a-zA-Z].*){${minLetter},}`).test(password);
    let checkSpecial = new RegExp(`(.*[!@#$%^&*(),.?":{}|<>].*){${minSpecial},}`).test(password);

    let checkAll = checkNumber && checkLetter && checkSpecial;

    if(password.length > minLength && checkAll){
        return validPassword;
    }
    else if(password.length < minLength){
        return errorLength;
    }
    else{
        return errorCheck;
    }
}

module.exports = checkPassword;
