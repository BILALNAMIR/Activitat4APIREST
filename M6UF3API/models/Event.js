import mongoose from "mongoose";

const eventSchema = new mongoose.Schema({
  title: String,
  category: String,
  price: Number,
  eventDate: Date,
  location: String,
  available: Boolean
});

export default mongoose.model("Event", eventSchema);
