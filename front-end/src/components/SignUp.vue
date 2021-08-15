<template>
    <div class=" signin" >
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

            <label>Password</label>
            <input type="password" class="form-control form-control-lg shadow-none" placeholder="password" />

            <label>Confirm Password</label>
            <input type="password" class="form-control form-control-lg shadow-none" placeholder="password" />

            <!--<div id="date-picker-example" class="md-form md-outline input-with-post-icon datepicker" inline="true">
                <input placeholder="Select date" type="text" id="example" class="form-control">
                <label for="example">Try me...</label>
                <i class="fas fa-calendar input-prefix"></i>
            </div>-->

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
            return {}
        }
    }
</script>