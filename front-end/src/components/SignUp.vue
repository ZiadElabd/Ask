<template>
    <div class=" signUp" >
        <form>
            <h3>Sign Up</h3>
            <span>Already have an account? </span>  <router-link to="/signin">Log in</router-link>
            <div class="form-group">
                <label>First Name</label>
                <input type="email" class="form-control form-control-lg" />
            </div>

            <div class="form-group">
                <label>Second Name</label>
                <input type="email" class="form-control form-control-lg" />
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email" class="form-control form-control-lg" placeholder="Username or e-mail" />
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control form-control-lg shadow-none" placeholder="password" />
            </div>

            <div class="form-group">
                <label>Confirm Password</label>
                <input type="password" class="form-control form-control-lg shadow-none" placeholder="confirm Password" />
            </div>

            <div class="form-group">
                <label>Date</label>
                <el-date-picker v-model="date" type="date" placeholder="Pick a date"> </el-date-picker>
            </div>

            <div class="form-group ">
                <button class="btn btn-primary btn-lg btn-full" type="submit"> Create new account </button>
            </div>
        </form>
            
    </div>
</template>

<script>
    export default {
        name: 'SignUp',
        data() {
            return {
                date: '',
            }
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
        margin-top: 15px;
        font-size: 10px;
    }
    .form-group label{
        margin-bottom: 5px;
        margin-right: 15px;
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