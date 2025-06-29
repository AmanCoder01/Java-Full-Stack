function parent() {
    let a = 4;

    return function () {
        console.log(a);

    }
}

// a function which return another function and it uses parent function variable or memebers