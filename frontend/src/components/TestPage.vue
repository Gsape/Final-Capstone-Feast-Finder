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
      <div v-for="restaurants in allRestaurants" :key="restaurant.id" class="listR"></div>
  </div>
</template>

<script>

import { mapGetters, mapActions } from 'vuex';

export default {
  name: "TestPage",
  methods: {
    ...mapActions(['fetchRestaurants'])
  },
  computed: mapGetters(['allRestaurants']),
  created(){
    this.fetchRestaurants();
  }
}
</script>

<style>

</style>