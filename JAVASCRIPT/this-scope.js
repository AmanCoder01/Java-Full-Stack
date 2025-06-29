console.log(this); // window

function print() {
    console.log(this); //window

}


const user = {
    name: "aman",
    func: function () {
        console.log(this.name); //currenet object

    }
}

user.func();
