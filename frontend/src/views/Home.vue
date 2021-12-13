<template>
  <div class="home">
    <h1>Feast Finder</h1>
    <sideBar/>
    <img src="GitForkedLogo.png" alt="logo" class="logo">
  </div>
</template>

<script>
import sideBar from "@/components/sideBar.vue";

export default {

  components: {sideBar},
  name: "home"
};
</script>

<style scoped>
  .logo {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}

</style>
