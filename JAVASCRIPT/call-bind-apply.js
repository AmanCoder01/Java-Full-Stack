let user = {
    name: "aman"
}

function print(x = 0, y = 0) {
    console.log(this, x, y);
}

print(); //  this represents window object


// call :- we use call to change this value in function

print.call(user); //  this represents user object now

// apply: we use apply to change this value in function and pass parameter to that function
print.apply(user, [1, 2]);

// apply: we use apply to change this value in function and  assign to new variable
let obj = print.bind(user, [1, 2]);
obj();
