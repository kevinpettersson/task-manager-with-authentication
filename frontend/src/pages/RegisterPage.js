function RegisterPage() {
    return (
        <>
            <h1>Register account</h1>

            <input type={"name"} name={"Username"} placeholder={"Enter username"}/>
            <br />
            <input type={"password"} name={"Password"} placeholder={"Enter password"}/>
            <br />
            <input type={"password"} name={"Password"} placeholder={"Confirm password"}/>
            <br />

            <button>Register account</button>
        </>
    );
}

export default RegisterPage