<template>
<div>
  <dataTest />
  <div>
    <!-- <div class="cardDisplay" v-for="restaurant in $store.state.cleanerResults" :key="restaurant.name">
      <single-card />
    </div> -->
  </div>
  
</div>
</template>



<script>
import dataTest from '../components/dataTest.vue'
// import authService from '../services/AuthService';
// import userService from '../services/UserService';
// import yelpService from '../services/YelpService';



// v-for="list in $store.state.searchResults" :key="list.businesses"
// v-for="restaurant in list.businesses" :key="restaurant.name"


export default {
  components: {
    dataTest
  }
  
}
</script>

<style>
.cardDisplay{
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}

</style>