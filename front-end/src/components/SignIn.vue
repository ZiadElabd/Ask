<template>
    <div class="container">
        <div class=" signin" >
        <form>
            <h3>Log in</h3>
            <span>don't have an account yet</span>  <router-link to="/signup">Sign Up</router-link>
            <div class="form-group">
                <label>Login</label>
                <input type="email" v-model="form.userName" class="form-control form-control-lg" placeholder="Username or e-mail" />
            </div>

                <label>Password</label>
                <input type="password" v-model="form.password" class="form-control form-control-lg shadow-none" placeholder="password" />
            <div class="form-group">
            </div>
            <div class="form-group ">
          <button class="btn btn-danger btn-lg btn-full danger" @click.prevent="login">
            Log in 
          </button>
        </div>
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
                    userName:'',
                    password:'',
                },
                checkState: false,
            }
        },
        methods:{
            parseJSON: function (resp) {
                return resp.text();
            },
            checkStatus1: function (resp) {
                console.log('status');
                if (resp.status >= 200 && resp.status < 300) {
                    console.log('good status');
                    return resp;
                }
                console.log('bad status');
                return this.parseJSON(resp).then((resp) => {
                    throw resp;
                });
            },
            async login(){
                try {
                    const response = await fetch( "http://localhost:5050/signin/" , {
                        method: "post" , 
                        headers: { "Content-Type": "application/json" },
                        body: JSON.stringify(this.form)
                    }).then(this.checkStatus1)
                    .then(this.parseJSON)
                    // console.log('ziad');
                    // console.log(response);
                    this.$store.commit('saveUserData',{
                        _id: response,
                        _name: this.form.userName
                    });
                    console.log(this.$store.state.userID);
                    this.$store.dispatch("getImage");
                    this.$router.push({ name: "Home" });
                } catch (error) {
                    alert('error');
                } 
                /*console.log("this is check ", this.checkState);
                if (this.checkState === true) {
                    alert("very good");
                    this.$router.push({ name: "SignUp" });
                    // window.open("#/signedIn");
                } else {
                    alert("Please try agian, email or password is wrong :(");
                }*/
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
.form-group
{
    margin-bottom: 10px;
}

</style>