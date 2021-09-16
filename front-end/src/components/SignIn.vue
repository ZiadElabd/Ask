<template>
    <div class="container">
        <div class=" signin" >
        <form>
            <h3>Log in</h3>
            <span>don't have an account yet</span>  <router-link to="/signup">Sign Up</router-link>
            <div class="form-group">
                <label>Login</label>
                <input type="email" v-model="form.email" class="form-control form-control-lg" placeholder="Username or e-mail" />
            </div>

                <label>Password</label>
                <input type="password" v-model="form.password" class="form-control form-control-lg shadow-none" placeholder="password" />
            <div class="form-group">
            </div>
            <div class="form-group ">
          <button class="btn btn-primary btn-lg btn-full" @click.prevent="login">
            Search
          </button>
        </div>


            <p class="forgot-password text-right mt-2 mb-4">
                <router-link to="/forgot-password">Forgot password ?</router-link>
            </p>


        </form>
            
    </div>
    </div>
</template>

<script>
    export default {
        name: 'SignIn',
        data() {
            return {
                form:{
                    email:'',
                    password:'',
                },
                checkState: false,
            }
        },
        methods:{
            async login(){
                await fetch( "http://localhost:8085/login/" , { 
                    method: "get" , 
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(this.form)
                }).then((response) => {
                    return response.json();
                }).then((data) => {
                    //console.log("this is data ", data);
                    this.checkState = data;
                });
                console.log("this is check ", this.checkState);
                if (this.checkState === true) {
                    alert("very good");
                    this.$router.push({ name: "SignUp" });
                    // window.open("#/signedIn");
                } else {
                    alert("Please try agian, email or password is wrong :(");
                }
            },

        }
    }
</script>
<style scoped>
.container
{
    width: 30%;
    padding-top: 30px;
}

</style>