<template>
    <div class=" signin" >
        <form>
            <h3>Create new account</h3>
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

            <div class="form-group ">
                <button class="btn btn-primary btn-lg btn-full" type="submit"> Create new account </button>
            </div>
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