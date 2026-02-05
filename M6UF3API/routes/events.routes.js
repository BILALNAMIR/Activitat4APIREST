import express from "express";
import Event from "../models/Event.js";

const router = express.Router();


// ➕ POST - afegir event
router.post("/", async (req, res) => {
  const event = new Event(req.body);
  await event.save();
  res.status(201).json(event);
});


// 📋 GET - tots els events
router.get("/", async (req, res) => {
  const events = await Event.find();
  res.json(events);
});


// 🔍 GET - cercar per nom
router.get("/search/:text", async (req, res) => {
  const events = await Event.find({
    title: { $regex: req.params.text, $options: "i" }
  });
  res.json(events);
});


// 📆 GET - entre dates
router.get("/dates", async (req, res) => {
  const { inici, fi } = req.query;

  const events = await Event.find({
    eventDate: {
      $gte: new Date(inici),
      $lte: new Date(fi)
    }
  });

  res.json(events);
});


// ❌ DELETE
router.delete("/:id", async (req, res) => {
  await Event.findByIdAndDelete(req.params.id);
  res.json({ msg: "Event eliminat" });
});


// ✏️ PUT - modificar
router.put("/:id", async (req, res) => {
  const event = await Event.findByIdAndUpdate(
    req.params.id,
    req.body,
    { new: true }
  );
  res.json(event);
});

export default router;
