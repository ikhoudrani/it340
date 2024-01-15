const checkPassword = require('./password'); 

describe('Test de la fonction checkPassword', () => {
    let minLength = 8;
    let minNumber = 1;
    let minLetter = 1;
    let minSpecial = 1;

    let errorLength = "Le mot de passe doit contenir au minimum " + minLength +" caratères.";
    let errorCheck = "Le mot de passe doit contenir au moins " + minNumber + " chiffre, " + minLetter + " lettre et " + minSpecial + " caractère spécial.";
    let validPassword = "Mot de passe valide.";

    test('Mot de passe valide', () => {
        expect(checkPassword('Valid@1222')).toBe(validPassword);
    });

    test('Manque un nombre', () => {
        expect(checkPassword('Validdddd@')).toBe(errorCheck);
    });

    test('Manque une lettre', () => {
        expect(checkPassword('1111111111')).toBe(errorCheck);
    });

    test('Manque un caractère spécial', () => {
        expect(checkPassword('Validdd55')).toBe(errorCheck);
    });

    test('Mot de passe trop court', () => {
        expect(checkPassword('V')).toBe(errorLength);
    });

});