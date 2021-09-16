<template>
  <div class="notifications">
    <Navbar />
  </div>
</template>

<script>
import Navbar from '../components/nbar.vue';

export default {
  name: 'Notifications',
  components: {
    Navbar
  }
}
</script>
<style scoped>
.notifications
{
  background-color: #131619;
}
</style>
