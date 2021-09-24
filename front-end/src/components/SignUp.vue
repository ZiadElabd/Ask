<template>
    <div class="container">
        <div class=" signUp" >
        <form>
            <h3>Sign Up</h3>
            <span>Already have an account? </span>  <router-link to="/">Log in</router-link>
            <div class="form-group">
                <label>First Name</label>
                <input type="text" placeholder="Enter your first name"  v-model="user.firstName" class="form-control form-control-lg" />
            </div>

            <div class="form-group">
                <label>Last Name</label>
                <input type="text" placeholder="Enter your last name"  v-model="user.lastName" class="form-control form-control-lg" />
            </div>

            <div class="form-group">
                <label>userName</label>
                <input type="email"  v-model="user.username" class="form-control form-control-lg" placeholder="Username" />
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email"  v-model="user.email" class="form-control form-control-lg" placeholder="Username or e-mail" />
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password"  v-model="user.password" class="form-control form-control-lg shadow-none" placeholder="password" />
            </div>

            <div class="form-group">
                <label>Confirm Password</label>
                <input type="password"  v-model="confirmPassword" class="form-control form-control-lg shadow-none" placeholder="confirm Password" />
            </div>

            <div class="form-group">
                <label>BirthDate</label>
                <el-date-picker v-model="user.birthDate" type="date" placeholder="Pick a date"> </el-date-picker>
            </div>

            <div class="form-group ">
                <button class="btn btn-danger btn-lg btn-full" type="submit" @click.prevent="create_new_account"> Create new account </button>
            </div>
        </form>
            
    </div>
    </div>
</template>

<script>
    export default {
        name: 'SignUp',
        data() {
            return {
                confirmPassword:'',
                user: {
                    firstName:'',
                    lastName:'',
                    username:'',
                    email:'',
                    password:'',
                    gender:'Male',
                    birthDate:'',
                },
            }
        },
        methods:{
            parseJSON: function (resp) {
                console.log(resp);
                console.log(resp.text());
                return resp.text() ? resp.text() : resp;
            },
            checkStatus: function (resp) {
                // console.log('status');
                // console.log(resp);
                // console.log(resp.status);
                if (resp.status >= 200 && resp.status < 300) {
                    console.log('good status');
                    return true;
                }
                console.log('bad status');
                return false;
            },

            check_password() {
                return this.user.password === this.user.confirmPassword;
            },

            async check_email(email){
                const response = await fetch("http://localhost:5050/checkUsername/" + email,{ 
                    method: "get" ,
                    headers: {'Content-Type': 'application/json'}
                });
                // console.log(response.status);
                // console.log('return of check function ' + this.checkStatus(response));
                return this.checkStatus(response);
            },
            async create_new_account(){
                if( ! this.check_password ){
                    alert("please make sure that the two passwords match");
                    return;
                }
                const valid = await this.check_email(this.user.username);
                //console.log("vvvvvv");
                console.log("valid " + valid);
                if( ! valid ){
                    alert("there is an account with ths userName");
                    return;
                }
                //console.log("check userName = true");
                fetch("http://localhost:5050/signup", {
                    method: "post",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(this.user),
                }).then((response) => {
                    return response.text();
                }).then((data) => {
                    console.log("signup =  " +  data);
                });
                alert("Signed up seccessfully");
                this.$router.push({ name: "SignIn" });
            },
        }
    }
</script>

<style scoped>  
  
    label {
        font-weight: 500;
    }
    .signUp{
        display: block;
        background-color: #FFF;
        height: auto;
        width: 500px;
        padding: 20px;
        border-radius: 5px;
    }
    form h3{
        margin-bottom: 0;
    }
    form span {
        font-size: 13px;
    }

    .form-group{
        display: flex;
        flex-direction: row;
        justify-content: left;
        align-items: center;
        margin-top: 15px;
        font-size: 10px;
    }
    .form-group label{
        width: 80px;
    }
    .form-group input{
        font-size: 13px;
        padding: 10px;
    }

    .form-control:focus,
    .btn:focus,.btn:active {
        border-color:#CCC;
        outline:0 !important;
        -webkit-box-shadow:none;
        box-shadow:none;
    }


    .btn-group-lg>.btn, .btn-lg 
    {width: 100%;}
.container
{
    width: 35%;
    padding-top: 30px;
}
 
</style>