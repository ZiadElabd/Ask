<template>
    <div class=" signin" >
        <form>
            <h3>Log in</h3>
            <span>don't have an account yet</span> <span>sign up</span>
            <div class="form-group">
                <label>Login</label>
                <input type="email" class="form-control form-control-lg" placeholder="Username or e-mail" />
            </div>

                <label>Password</label>
                <input type="password" class="form-control form-control-lg shadow-none" placeholder="password" />
            <div class="form-group">
            </div>
            <div class="form-group ">
          <button class="btn btn-primary btn-lg btn-full" type="submit">
            Search
          </button>
        </div>


            <p class="forgot-password text-right mt-2 mb-4">
                <router-link to="/forgot-password">Forgot password ?</router-link>
            </p>


        </form>
            
    </div>
</template>

<script>
    export default {
        data() {
            return {}
        }
    }
</script>