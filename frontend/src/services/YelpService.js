import axios from 'axios';

const http = axios.create({
  baseURL: "https://api.yelp.com/v3/businesses/search?term=delis&location=15206",
  headers: {
    Authorization: `Bearer ${this.$store.state.yelpToken}`
  }
});

export default {
    getRestaurants(){
        return http.get();
    }
}