import axios from "axios";
export default axios.create({
    baseURL:'  https://5b03-103-15-65-82.in.ngrok.io',
    headers: {"ngrok-skip-browser-warning":"true"}
});