import express from "express";
import Event from "../models/Event.js";

const router = express.Router();


// afegir event
router.post("/", async (req, res) => {
  const event = new Event(req.body);
  await event.save();
  res.status(201).json(event);
});

// tots els events
router.get("/list", async (req, res) => {
  const events = await Event.find();
  res.json(events);
});
// cercar per nom
router.get("/search/:text", async (req, res) => {
  const events = await Event.find ({
    title: { $regex: req.params.text, $options:"i"}
  });
  res.json(events);
});

//  entre dates
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


//  DELETE
router.delete("/:id", async (req, res) => {
   await Event.findByIdAndDelete(req.params.id);
  res.json({ msg: "Event eliminat" });
});



// modificar
router.put("/:id", async (req, res) => {
  const event = await Event.findByIdAndUpdate(
    req.params.id,
    req.body,
    { new: true }
  );
  res.json(event);
});

export default router;
