<template>
    <div class=" signUp" >
        <form>
            <h3>Sign Up</h3>
            <span>Already have an account? </span>  <router-link to="/signin">Log in</router-link>
            <div class="form-group">
                <label>First Name</label>
                <input type="email"  v-model="user.firstName" class="form-control form-control-lg" />
            </div>

            <div class="form-group">
                <label>Second Name</label>
                <input type="email"  v-model="user.secondName" class="form-control form-control-lg" />
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
                <label>Choose Date</label>
                <el-date-picker v-model="user.date" type="date" placeholder="Pick a date"> </el-date-picker>
            </div>

            <div class="form-group ">
                <button class="btn btn-primary btn-lg btn-full" type="submit" @click="create_new_account"> Create new account </button>
            </div>
        </form>
            
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
                    secondName:'',
                    email:'',
                    password:'',
                    date: '',
                },
            }
        },
        methods:{

            check_password() {
                return this.user.password === this.user.confirmPassword;
            },

            check_email(email){
                return fetch("http://localhost:8085/" + this.form.username,{ method: "get"} )
                .then((response) => {
                    return response.json();
                }).then((data) => {
                    return data
                });
            },

            create_new_account(){
                if(this.check_password){
                    if(!this.check_email){
                        fetch("http://localhost:8085/", {
                            method: "post",
                            headers: { "Content-Type": "application/json" },
                            body: JSON.stringify(this.user),
                        });
                        alert("Signed up seccessfully");
                        //this.$router.push({ name: "signIn" });
                    }else{
                        alert("there is an account with ths email");
                    }
                }else{
                    alert("please make sure that the two passwords match");
                }
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
        justify-content: center;
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
        border-radius: 10px;
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
 
</style>