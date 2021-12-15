<template>
<div>
  <dataTest />
  <div>
    <div class="cardDisplay">
      <single-card />
    </div>
  </div>
  
</div>
</template>



<script>
import dataTest from '../components/dataTest.vue'
import SingleCard from '../components/SingleCard.vue'
// import authService from '../services/AuthService';
// import userService from '../services/UserService';
// import yelpService from '../services/YelpService';



// v-for="list in $store.state.searchResults" :key="list.businesses"
// v-for="restaurant in list.businesses" :key="restaurant.name"


export default {
  components: {
    dataTest,
    
    SingleCard
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