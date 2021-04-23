
// if (document.getElementById("btnValider") != null)
//     document.getElementById("btnValider").addEventListener("click",() =>{
//         messageAlert()
//     });

if (document.getElementById("dropPicker") != null)
    document.getElementById("dropPicker").addEventListener("change",() =>{
        fildForm()
    });
if (document.getElementById("btnUpdate") != null)
    document.getElementById("btnUpdate").addEventListener("click",() =>{
    document.getElementById("alert").innerHTML = "L'étudiant à été modifier";
    document.getElementById("alert").style.color = "green";

});


function fildForm() {

    let etu = new  Etudiant()
    document.querySelector('select').value.split("\n").forEach((val) => {
        switch (val.split("=")[0]) {
            case "id":
                etu.id = val.split("=")[1];
                break;
            case "nom":
                etu.name = val.split("=")[1];
                break;
            case "email":
                etu.email = val.split("=")[1];
                break;
            case "prenom":
                etu.lastName = val.split("=")[1];
                break;
            case "telephone":
                etu.phone = val.split("=")[1];
                break;
            case "adresse":
                etu.address = val.split("=")[1];
                break;
        }
    });

    document.getElementById("name").value = etu.name;
    document.getElementById("lastName").value = etu.lastName;
    document.getElementById("address").value = etu.address;
    document.getElementById("phone").value = etu.phone;
    document.getElementById("birthday").value = etu.birthday;
    document.getElementById("email").value = etu.email;
}

class Etudiant {

    constructor(id,name,lastName,address,phone,birthday,email) {
        this._id = id;
        this._name = name;
        this._lastName = lastName;
        this._address = address;
        this._phone = phone;
        this._birthday = birthday;
        this._email = email;
    }

    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get name() {
        return this._name;
    }

    set name(value) {
        this._name = value;
    }

    get lastName() {
        return this._lastName;
    }

    set lastName(value) {
        this._lastName = value;
    }

    get address() {
        return this._address;
    }

    set address(value) {
        this._address = value;
    }

    get phone() {
        return this._phone;
    }

    set phone(value) {
        this._phone = value;
    }

    get birthday() {
        return this._birthday;
    }

    set birthday(value) {
        this._birthday = value;
    }

    get email() {
        return this._email;
    }

    set email(value) {
        this._email = value;
    }
}