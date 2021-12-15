<template>
  <div>
    <!-- <h1>Restaurant</h1> -->
    <!-- <h2>{{ restaurant }}</h2> -->
    <!-- <h2>{{ restaurant }}</h2> -->
    <!-- <h2>{{ restaurant.id }}</h2>
    <h2>{{ restaurant.rating }}</h2> -->

    <!-- <ul>
      <li v-for="list in $store.state.searchResults" :key="list.businesses">
          <p v-for="restaurant in list.businesses" :key="restaurant.name">
              {{ restaurant.name }}
          </p>
      </li>
    </ul> -->

    <!-- <h1>Profile</h1> -->
    <h1></h1>
    <h1></h1>
    <h1></h1>
    <h1></h1>
  </div>
</template>

<script>
// import yelpService from "../services/YelpService";

export default {
  name: "data-test",
  data() {
    return {
      businessID: '',
      address: '',
      responseJSON: {},
    };
  },

  //   gR9DTbKCvezQlqvD7_FzPw

  // methods: {
    // getRestaurant() {
    //   yelpService
    //     .getSingleRestaurant(this.$route.params.businessID) // this.$route.params.businessID
    //     .then((response) => {
    //         this.$store.commit("SET_RESTAURANT", response.data);
    //         // this.$router.push('/')
    //     })
    //     .catch(error => {
    //       if (error.response && error.response.status === 404) {
    //         alert("noooo");
    //         console.log(error.response.status)
    //       }
    //       // this.$router.push("/login");
    //     });
    // },

    // submitRestaurant() {
    //     const newRestaurant = {
    //         businessID: this.restaurant.businessID,
    //         business: this.restaurant.business,
    //         address: this.restaurant.address,
    //         imgURL: this.restaurant.imgURL,
    //         phone: this.restaurant.phone,
    //         rating: this.restaurant.rating,
    //         price: this.restaurant.price,
    //         cuisine: this.restaurant.cuisine
    //
    // },
  // },

  // created() {
  //   this.getRestaurant();
  // },

  computed: {
    restaurant() {
      return this.$store.state.restaurant;
    },

    JSONObject() {
      return this.$store.state.responseJSON;
    }
  // },
}
}

</script>