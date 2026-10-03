import {
  ArrowUpRight,
  BriefcaseBusiness,
  ChevronRight,
  Plus,
} from "lucide-react";
import { Navbar } from "@/components/Navbar";

const stats = [
  ["12k+", "open roles"],
  ["3.8k", "companies"],
  ["42", "countries"],
];

export function HomePage() {
  return (
    <div id="top" className="min-h-screen bg-background text-foreground">
      <Navbar />
      <main>
        <section className="border-b border-border">
          <div className="mx-auto grid max-w-6xl gap-10 px-5 py-16 sm:py-20 lg:grid-cols-[1.15fr_0.85fr] lg:items-end lg:px-8 lg:py-24">
            <div>
              <p className="mb-5 flex items-center gap-2 text-xs font-semibold uppercase tracking-[0.14em] text-accent">
                <span className="size-2 bg-accent" /> Jobys for ambitious people
              </p>
              <h1 className="max-w-2xl text-4xl font-semibold leading-[1.08] tracking-tight sm:text-5xl">
                Find work worth doing.
              </h1>
              <p className="mt-5 max-w-lg text-base leading-7 text-muted-foreground">
                A better place to discover teams, roles, and opportunities that
                move you forward.
              </p>
              <a
                href="#jobs"
                className="mt-8 inline-flex items-center gap-2 bg-accent px-5 py-3 text-sm font-semibold text-accent-foreground transition-colors hover:bg-accent/90"
              >
                Explore open roles <ArrowUpRight size={16} />
              </a>
            </div>
            <div className="border-l-2 border-accent pl-6 lg:mb-1">
              <p className="text-sm font-medium leading-6">
                The job search, with less noise.
              </p>
              <p className="mt-3 text-sm leading-6 text-muted-foreground">
                Useful opportunities from companies building the future of work.
              </p>
            </div>
          </div>
        </section>

        <section
          aria-label="Jobys statistics"
          className="border-b border-border"
        >
          <div className="mx-auto grid max-w-6xl grid-cols-3 px-5 lg:px-8">
            {stats.map(([value, label]) => (
              <div
                key={label}
                className="border-r border-border px-3 py-7 first:pl-0 last:border-r-0 sm:px-6 sm:py-8"
              >
                <p className="text-xl font-semibold tracking-tight sm:text-2xl">
                  {value}
                </p>
                <p className="mt-1 text-xs text-muted-foreground">{label}</p>
              </div>
            ))}
          </div>
        </section>

        <section
          id="jobs"
          className="mx-auto max-w-6xl px-5 py-16 lg:px-8 lg:py-20"
        >
          <div className="flex items-end justify-between gap-4 border-b border-foreground pb-4">
            <div>
              <p className="text-xs font-semibold uppercase tracking-[0.14em] text-accent">
                Coming next
              </p>
              <h2 className="mt-2 text-2xl font-semibold tracking-tight">
                Open roles
              </h2>
            </div>
            <span className="text-xs text-muted-foreground">
              Your job feed will live here
            </span>
          </div>
          <div className="grid min-h-52 place-items-center border-b border-border bg-card px-6 py-12 text-center">
            <div>
              <div className="mx-auto grid size-10 place-items-center border border-border text-muted-foreground">
                <BriefcaseBusiness size={18} />
              </div>
              <p className="mt-4 text-sm font-medium">Jobs are on their way.</p>
              <p className="mt-1 text-xs text-muted-foreground">
                This space is ready for the jobs API and filters.
              </p>
            </div>
          </div>
        </section>

        <section className="border-y border-border bg-accent text-accent-foreground">
          <div className="mx-auto flex max-w-6xl flex-col gap-6 px-5 py-12 sm:flex-row sm:items-center sm:justify-between lg:px-8 lg:py-14">
            <div>
              <p className="text-xs font-semibold uppercase tracking-[0.14em] text-accent-foreground/70">
                For teams
              </p>
              <h2 className="mt-2 text-2xl font-semibold tracking-tight">
                Build your team with Jobys.
              </h2>
            </div>
            <a
              href="#employers"
              className="inline-flex items-center gap-2 self-start border border-accent-foreground/40 px-4 py-2.5 text-sm font-semibold transition-colors hover:bg-accent-foreground hover:text-accent sm:self-auto"
            >
              Post a role <ChevronRight size={16} />
            </a>
          </div>
        </section>
      </main>
      <footer className="mx-auto flex max-w-6xl flex-col gap-4 px-5 py-8 text-xs text-muted-foreground sm:flex-row sm:items-center sm:justify-between lg:px-8">
        <a
          href="#top"
          className="flex items-center gap-2 font-semibold text-foreground"
        >
          <span className="grid size-6 place-items-center bg-accent text-accent-foreground">
            <Plus size={14} />
          </span>
          jobys
        </a>
        <div className="flex gap-5">
          <a href="#about" className="hover:text-foreground">
            About
          </a>
          <a href="#contact" className="hover:text-foreground">
            Contact
          </a>
          <a href="#privacy" className="hover:text-foreground">
            Privacy
          </a>
        </div>
      </footer>
    </div>
  );
}
