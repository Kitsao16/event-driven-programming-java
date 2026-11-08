Observation – FreezeDemo: The application became temporarily unresponsive because Thread.sleep(5000) blocked the Event Dispatch Thread. The EDT could not process other events during that period.

Observation – FixedDemo: The application remained responsive because the lengthy operation was executed on a separate background thread. SwingUtilities.invokeLater() was used to update the GUI safely on the EDT.
