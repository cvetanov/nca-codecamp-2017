const priorities = [
  {
    value: 'PRIORITY_DEFAULT',
    text: 'Priority Default'
  },
  {
    value: 'PRIORITY1',
    text: 'Priority 1'
  },
  {
    value: 'PRIORITY2',
    text: 'Priority 2'
  },
  {
    value: 'DEADLINE',
    text: 'Deadline'
  }
];

const prioritiesLookup = priorities.reduce(
  (acc, curr) => ({ ...acc, [curr.value]: curr.text }),
  {}
);

const statuses = [
  {
    value: 'CREATED',
    text: 'Created'
  },
  {
    value: 'LINED_UP',
    text: 'Lined up next'
  },
  {
    value: 'SCHEDULED',
    text: 'Scheduled'
  },
  {
    value: 'COMPLETED',
    text: 'Completed'
  },
  {
    value: 'ARCHIVED',
    text: 'Archived'
  }
];

const statusesLookup = statuses.reduce(
  (acc, curr) => ({ ...acc, [curr.value]: curr.text }),
  {}
);

export { priorities, prioritiesLookup, statuses, statusesLookup };
