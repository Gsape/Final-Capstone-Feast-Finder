<template>
  <div>
      <h1>JWT Token</h1>
      <p></p>
      <h1>Profile</h1>
      <p></p>
      <h1>Loved</h1>
      <p></p>
      <h1>Hated</h1>
      <p></p>
      <h1>Single Restaurant</h1>
      <p></p>
      <h1>List of Restaurants</h1>
      <p></p>
  </div>
</template>

<script>
import YelpService from "../services/YelpService";

export default {
  methods: {
    listRestaurants(){
      YelpService.getRestaurants().then(response => {
        this.$store.commit("SET_RESTAURANTS", response.data);
      })
    }
  }
}
</script>

<style>

</style>